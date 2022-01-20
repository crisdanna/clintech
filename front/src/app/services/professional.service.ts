import { Injectable } from '@angular/core';
import { HttpService } from './http.service';

@Injectable({
  providedIn: 'root',
})
export class ProfessionalService {
  professionalPath = '/professional';

  constructor(private http: HttpService) {}

  get() {
    return this.http.findAll<any>(`${this.professionalPath}/list`).toPromise();
  }
}
