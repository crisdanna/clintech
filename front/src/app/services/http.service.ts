import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class HttpService {
  constructor(private http: HttpClient) {}

  public findOne<T>(endpoint: string): Observable<T> {
    return this.http.get<T>(`${environment.api}${endpoint}`);
  }

  public findAll<T>(endpoint: string): Observable<T> {
    return this.http.get<T>(`${environment.api}${endpoint}`);
  }

  public create<T>(endpoint: string, data: T): Observable<T> {
    return this.http.post<T>(`${environment.api}${endpoint}`, data);
  }

  public update<T>(endpoint: string, data: T): Observable<T> {
    return this.http.put<T>(`${environment.api}${endpoint}`, data);
  }

  public delete<T>(endpoint: string): Observable<T> {
    return this.http.delete<T>(`${environment.api}${endpoint}`);
  }
}
