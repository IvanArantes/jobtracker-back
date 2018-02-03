import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Vacancy } from '../../domain/model/vacancy.model';
import 'rxjs/Rx';

@Injectable()
export class VacancyService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get('//localhost:8181/vacancies');
  }

  public save(vacancy: Vacancy): Observable<any> {
    return this.http.post('//localhost:8181/vacancies', vacancy)
    .map(resp => resp as any)
    .catch(err => {throw err})
  }
}
