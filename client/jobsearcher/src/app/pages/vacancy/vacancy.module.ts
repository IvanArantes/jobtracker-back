import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { VacancyService } from '../../shared/service/vacancy.service';
import { VacancyRoutingModule } from './vacancy-routing.module';
import { CreateVacancyComponent } from './create-vacancy/create-vacancy.component';
import { ListVacancyComponent } from './list-vacancy/list-vacancy.component';
import { SharedModule } from '../../shared/shared.module';


@NgModule({
  imports: [
    CommonModule,
    VacancyRoutingModule,
    SharedModule
  ],
  declarations: [
  CreateVacancyComponent,
  ListVacancyComponent],
  providers: [VacancyService]
})
export class VacancyModule { }
