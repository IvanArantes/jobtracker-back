import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';
import { HttpHeaders } from '@angular/common/http/src/headers';
import { Skill } from '../../domain/model/skill.model';

@Injectable()
export class SkillService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Skill[]> {
      console.log('is here');
    return this.http.get('//localhost:8080/skills')
    .map(resp => resp as Skill[]);
  }
}
