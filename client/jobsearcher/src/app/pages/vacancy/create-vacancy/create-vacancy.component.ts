import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, FormBuilder, Validators } from '@angular/forms';
import { VacancyService } from '../../../shared/service/vacancy.service';
import { Skill } from '../../../domain/model/skill.model';
import { SkillService } from '../../../shared/service/skill.service';


@Component({
  selector: 'app-create-vacancy',
  templateUrl: './create-vacancy.component.html',
  styleUrls: ['./create-vacancy.component.css']
})
export class CreateVacancyComponent implements OnInit {
  vacancyForm: FormGroup;
  skillList: Skill[];

  constructor(private fb: FormBuilder, private service: VacancyService, 
  private skillService: SkillService) { 
    this.createForm();
  }

  ngOnInit() {
    this.LoadSkills();
  }

  private createForm() {
    this.vacancyForm = this.fb.group({
        company: ['', Validators.required],
        role: ['', Validators.required],
        level: '',
        skills: [this.skillList, Validators.required],
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

  private LoadSkills(){
    this.skillService.getAll()
    .subscribe((resp: Skill[]) => {
      this.skillList = resp;
    })
  }
}
