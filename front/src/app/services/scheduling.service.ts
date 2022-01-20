import { Injectable } from '@angular/core';
import { from, Observable } from 'rxjs';
import { HttpService } from './http.service';

@Injectable({
  providedIn: 'root',
})
export class SchedulingService {
  appointmentPath = '/appointment';

  constructor(public http: HttpService) {}

  get(): Promise<any> {
    return this.http.findAll(`${this.appointmentPath}/list/7`).toPromise();
  }

  create(data: any) {
    return this.http.create(`${this.appointmentPath}`, data).toPromise();
  }

  update(data: any) {
    return this.http.create(`${this.appointmentPath}`, data).toPromise();
  }

  delete(id: number) {
    return this.http
      .delete(`${this.appointmentPath}/${id}`)
      .toPromise()
      .then(() => console.log('Item deletado com sucesso'))
      .catch((err: any) => console.log('error: ' + err));
  }
}
