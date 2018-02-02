import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateVacancyComponent } from './create-vacancy/create-vacancy.component';

const routes: Routes = [
  { path: 'vacancies', component: CreateVacancyComponent }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class VacancyRoutingModule { }
