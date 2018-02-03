import { Component, OnInit } from '@angular/core';
import {VacancyService} from '../../../shared/service/vacancy.service';
import {Vacancy} from '../../../domain/model/vacancy.model';

@Component({
  selector: 'app-list-vacancy',
  templateUrl: './list-vacancy.component.html',
  styleUrls: ['./list-vacancy.component.css']
})
export class ListVacancyComponent implements OnInit {

  vacancies: Array<Vacancy>
  constructor(private vacancyService: VacancyService) { }

  ngOnInit() {            
    this.vacancyService.getAll().subscribe(data => {
            this.vacancies = data;
        });
      }
}
