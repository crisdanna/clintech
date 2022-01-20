import { Injectable } from '@angular/core';
import { from, Observable } from 'rxjs';
import { HttpService } from './http.service';

@Injectable({
  providedIn: 'root',
})
export class MailService {
  mailPath = 'http://localhost:8090/clintech/mail';

  constructor(public http: HttpService) {}

  send(data: any) {
    return this.http.send(`${this.mailPath}`, data).toPromise();
  }
}
