import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { SchedulingService } from 'src/app/services/scheduling.service';
import { ConfirmComponent } from '../confirm/confirm.component';
import { FormComponent } from '../form/form.component';
import { InfoComponent } from '../info/info.component';
import * as moment from 'moment';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss'],
})
export class ListComponent implements OnInit {
  schedules: Array<any> = [];
  constructor(
    private schedulingService: SchedulingService,
    public dialog: MatDialog
  ) {}

  ngOnInit(): void {
    this.get();
  }

  async get() {
    this.schedules = await this.schedulingService.get();
    console.log(this.schedules);
  }

  info(item: any) {
    this.dialog.open(InfoComponent, { data: item });
  }

  create() {
    const dialogRef = this.dialog.open(FormComponent);
    dialogRef.afterClosed().subscribe(() => this.get());
  }

  edit(item: any) {
    const dialogRef = this.dialog.open(FormComponent, { data: item });
    dialogRef.afterClosed().subscribe(() => this.get());
  }

  async remove(id: number) {
    const dialogRef = this.dialog.open(ConfirmComponent);
    dialogRef.afterClosed().subscribe(async (result) => {
      if (result) await this.schedulingService.delete(id);
      this.get();
    });
  }

  formatDate(date: string) {
    return moment(new Date(date)).format('DD/MM/YYYY');
  }
}
