import * as moment from 'moment';
import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {RestService} from "../rest/rest.service";
import {Auth} from "./auth.model";
import {Observable} from "rxjs/Observable";

@Injectable()
export class AuthService {

  constructor(private http: HttpClient,
              private restService: RestService) {

  }

  login(username: string, password: string ) : Observable<Auth> {
    const url = `${this.restService.getUrl()}auth/login`;
    return this.http.post<Auth>(url, {username, password})
      .do(res => this.setSession(res))
      .shareReplay();
  }

  private setSession(authResult: Auth) {
    //const expiresAt = moment().add(authResult.expiresIn, 'second');

    localStorage.setItem('id_token', authResult.token);
    //localStorage.setItem('expires_at', JSON.stringify(expiresAt.valueOf()) );
  }

  logout() {
    localStorage.removeItem('id_token');
    localStorage.removeItem('expires_at');
  }

  public isLoggedIn() {
    return moment().isBefore(this.getExpiration());
  }

  isLoggedOut() {
    return !this.isLoggedIn();
  }

  getExpiration() {
    const expiration = localStorage.getItem('expires_at');
    const expiresAt = JSON.parse(expiration);
    return moment(expiresAt);
  }

  getToken() {
    return localStorage.getItem('id_token');
  }
}
