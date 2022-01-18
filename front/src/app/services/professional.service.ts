import { Injectable } from '@angular/core';
import { HttpService } from './http.service';

@Injectable({
  providedIn: 'root',
})
export class ProfessionalService {
  professionalPath = 'http://localhost:8086/clintech/professional';

  constructor(private http: HttpService) {}

  get() {
    return this.http.findAll<any>(`${this.professionalPath}/list`).toPromise();
  }
}
