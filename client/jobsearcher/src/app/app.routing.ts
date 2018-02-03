import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CreateVacancyComponent } from './pages/vacancy/create-vacancy/create-vacancy.component';

const routes: Routes = [
    {path: '', component: CreateVacancyComponent },
    { path: '**', redirectTo: '' }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {}