import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { VacancyService } from '../../../shared/service/vacancy.service';


@Component({
  selector: 'app-create-vacancy',
  templateUrl: './create-vacancy.component.html',
  styleUrls: ['./create-vacancy.component.css']
})
export class CreateVacancyComponent implements OnInit {
  vacancyForm: FormGroup;

  constructor(private fb: FormBuilder, private service: VacancyService) { 
    this.createForm();
  }

  ngOnInit() {
  }

  private createForm() {
    this.vacancyForm = this.fb.group({
        company: ['', Validators.required],
        role: ['', Validators.required],
        level: '',
        skills: ['', Validators.required],
        xpTime: '',
        quality: '',
        url: '',
        description: '',
        dtVacancy: ['', Validators.required]

    })
}
  public onFormSubmit(){
    console.log(this.vacancyForm.value);
    this.service.save(this.vacancyForm.value).subscribe(
      resp => {
        console.log(resp);
      }
    );
  }
}
