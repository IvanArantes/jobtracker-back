ALTER TABLE public.VACANCY DROP COLUMN skills;
ALTER TABLE public.VACANCY ADD COLUMN skills serial;

ALTER TABLE public.VACANCY 
ADD constraint fk_vacancy_skills
FOREIGN KEY (skills) references skill (id);
