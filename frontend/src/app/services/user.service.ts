import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { User } from '../models/user';
import { Equipe } from '../models/equipe';
import { Role } from '../models/role';
@Injectable({
  providedIn: 'root'
})
export class UserService {

  private getUrl: string = "http://localhost:9090/api/chefs";
  private getUrll: string = "http://localhost:9090/api/roles";
  private getUrlll: string = "http://localhost:9090/api/equipes";
  constructor(private _httpClient: HttpClient) { }

  getChefs(): Observable<User[]> {
    return this._httpClient.get<User[]>(this.getUrl).pipe(
      map(response => response)
    )
  }
 
  getTeams(id: number): Observable<User> {
    return this._httpClient.get<User>(`${this.getUrl}/${id}`).pipe(
      map(response => response)
    )
  }
   saveUser(user: User): Observable<User> {
    return this._httpClient.post<User>(this.getUrl, user);
  }
  saveEquipe(id: any,equipe: Equipe): Observable<Equipe> {
    return this._httpClient.post<Equipe>(`${this.getUrlll}/${id}`,equipe);
  }

  


  geRoles(): Observable<Role[]> {
    return this._httpClient.get<Role[]>(this.getUrll).pipe(
      map(response => response)
    )
  }
 

}

