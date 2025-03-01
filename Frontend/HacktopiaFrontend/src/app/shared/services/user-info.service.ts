import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { UserInfo } from '@models/user-info.model';

@Injectable({
  providedIn: 'root',
})
export class UserInfoService {
  private readonly API_BASE = 'http://localhost:8079/api/person';

  constructor(private http: HttpClient) {}

  getUserInfo(name: string): Observable<UserInfo> {
    return this.http.get<UserInfo>(`${this.API_BASE}/${name}`);
  }
}
