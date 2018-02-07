import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Vacancy } from '../../domain/model/vacancy.model';
import 'rxjs/Rx';
import { Auth } from '../../core/auth/auth.model';
import { AuthService } from '../../core/auth/auth.service';
import { HttpHeaders } from '@angular/common/http/src/headers';

@Injectable()
export class VacancyService {

  constructor(private http: HttpClient, private auth: AuthService) { }

  getAll(): Observable<any> {
    return this.http.get('//localhost:8080/vacancies');
  }

  public save(vacancy: Vacancy): Observable<any> {
    //let headers = new HttpHeaders({ 'Authorization': 'Bearer ' + this.auth.getToken() });
    return this.http.post('//localhost:8080/vacancies', vacancy)
    .map(resp => resp as any)
    .catch(err => {throw err})
  }
}
