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
    return this.http.get<T>(`${endpoint}`);
  }

  public findAll<T>(endpoint: string): Observable<T> {
    return this.http.get<T>(`${endpoint}`);
  }

  public create<T>(endpoint: string, data: T): Observable<T> {
    return this.http.post<T>(`${endpoint}`, data);
  }

  public update<T>(endpoint: string, data: T): Observable<T> {
    return this.http.put<T>(`${endpoint}`, data);
  }

  public delete<T>(endpoint: string): Observable<T> {
    return this.http.delete<T>(`${endpoint}`);
  }

  public send<T>(endpoint: string, data: T): Observable<T> {
    return this.http.post<T>(`${endpoint}`, data);
  }
}
