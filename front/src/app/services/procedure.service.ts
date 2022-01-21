import { Injectable } from '@angular/core';
import { HttpService } from './http.service';

@Injectable({
  providedIn: 'root',
})
export class ProcedureService {
  procedurePath = 'http://localhost:8084/clintech/procedure';

  constructor(private http: HttpService) {}

  get() {
    return this.http.findAll<any>(`${this.procedurePath}/list`).toPromise();
  }
}
