import { Skill } from "./skill.model";

export class Vacancy{
    public company: String;
	public role: String;
	public level: String;
	public skills: Skill[];
	public xpTime: number;
	public quality: String;
	public url: String;
	public descricao: String;
	public dtVacancy: Date;
	public dtCreation: Date;
}