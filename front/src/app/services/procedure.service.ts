import { Injectable } from '@angular/core';
import { HttpService } from './http.service';

@Injectable({
  providedIn: 'root',
})
export class ProcedureService {
  procedurePath = '/procedure';

  constructor(private http: HttpService) {}

  get() {
    return this.http.findAll<any>(`${this.procedurePath}/list`).toPromise();
  }
}
