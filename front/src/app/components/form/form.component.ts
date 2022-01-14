import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import {
  DateAdapter,
  MAT_DATE_FORMATS,
  MAT_DATE_LOCALE,
} from '@angular/material/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ProcedureService } from 'src/app/services/procedure.service';
import { ProfessionalService } from 'src/app/services/professional.service';
import { SchedulingService } from 'src/app/services/scheduling.service';
import {
  MAT_MOMENT_DATE_ADAPTER_OPTIONS,
  MAT_MOMENT_DATE_FORMATS,
  MomentDateAdapter,
} from '@angular/material-moment-adapter';
import * as moment from 'moment';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss'],
  providers: [
    { provide: MAT_DATE_LOCALE, useValue: 'pt-BR' },
    { provide: MAT_DATE_FORMATS, useValue: MAT_MOMENT_DATE_FORMATS },
    {
      provide: DateAdapter,
      useClass: MomentDateAdapter,
      deps: [MAT_DATE_LOCALE, MAT_MOMENT_DATE_ADAPTER_OPTIONS],
    },
  ],
})
export class FormComponent implements OnInit {
  form!: FormGroup;

  procedures: Array<any> = [];
  professionals: Array<any> = [];

  constructor(
    private procedureService: ProcedureService,
    private professionalService: ProfessionalService,
    private schedulingService: SchedulingService,
    private formBuilder: FormBuilder,
    private dialogRef: MatDialogRef<FormComponent>,
    @Inject(MAT_DIALOG_DATA) public data: any
  ) {
    const formGroup = {
      patient: [{ id: 7 }],
      procedure: [null],
    };

    this.form = this.formBuilder.group({
      id: [null],
      date: [null],
      professional: [null],
      time: ['13:10'],
      treatment: new FormBuilder().group(formGroup),
    });
  }

  async ngOnInit(): Promise<void> {
    this.procedures = await this.procedureService.get();
    this.professionals = await this.professionalService.get();

    if (this.data) {
      this.form.patchValue({ ...this.data, date: new Date(this.data.date) });
    }
  }

  onSubmit() {
    const form = this.form.getRawValue();
    form.date = moment(form.date).format('MM/DD/YYYY');

    if (this.data) {
      form.treatment.id = this.data.treatment.id;
      form.treatment.authorizationNumber =
        this.data.treatment.authorizationNumber;
      this.schedulingService
        .update(form)
        .then(() => this.dialogRef.close())
        .catch((err) => console.log('Erro ao cadastrar agendamento - ' + err));
    } else {
      this.schedulingService
        .create(form)
        .then(() => this.dialogRef.close())
        .catch((err) => console.log('Erro ao cadastrar agendamento - ' + err));
    }
  }

  public compareSelectedObject(optionOne: any, optionTwo: any): boolean {
    return optionOne && optionTwo ? optionOne.id === optionTwo.id : false;
  }
}
