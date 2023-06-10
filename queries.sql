-- Part 1: Test it with SQL
-- id (INTEGER)
-- name (VARCHAR(255))
-- employer_id (INTEGER)
-- skills varchar(255)
-- Part 2: Test it with SQL
SELECT name
FROM employer
WHERE location = 'St. Louis, City.';
-- Part 3: Test it with SQL
DROP TABLE job;
-- Part 4: Test it with SQL
SELECT *
FROM skill
LEFT JOIN job_skills ON job_skills.skills_id = skill.id
WHERE job_skills.jobs_id IS NOT NULL
ORDER BY name ASC;