USE school;
CALL syntheticData();	-- please use this to enter synthetic data

-- ----------------------------------------------------------------
-- SQL QUERIES
-- ----------------------------------------------------------------
/*

SELECT * FROM students;

SELECT * FROM trainers;

SELECT * FROM assignments;

SELECT * FROM courses;

-- Students per Course
SELECT c.ctitle as Course, s.sfname as 'First Name', s.slname as 'Last Name'
FROM enrollments as e, students as s, courses as c
WHERE e.st_id=s.id
AND e.co_id=c.id
GROUP BY c.id, s.id;

-- Trainers per Course
SELECT c.ctitle as Course, t.tfname as 'First Name', t.tlname as 'Last Name'
FROM personnel as p, trainers as t, courses as c
WHERE p.co_id=c.id AND p.tr_id=t.id
GROUP BY c.id, t.id;

-- Assignments per Course
SELECT c.ctitle as Course, a.atitle as 'Assignment Title', a.adescr as 'Assignment Description', a.asubDate as 'Submission Date'
FROM assignments as a, courses as c
WHERE a.co_id=c.id
GROUP BY c.id, a.id;

-- Assignments per Course per Student;
SELECT s.sfname as 'First Name', s.slname as 'Last Name', c.ctitle as Course, a.atitle as 'Assignment', a.asubDate as 'Submission Date'
FROM students as s, homeworks as h, assignments as a, courses as c
WHERE s.id=h.st_id AND h.as_id=a.id AND a.co_id=c.id
GROUP BY s.id, c.id, a.id;

-- List of Students who belong to more than one Courses.
SELECT s.id as id, s.sfname as 'First Name', s.slname as 'Last Name', count(st_id) as Enrollments
FROM enrollments as e, students as s
WHERE e.st_id=s.id
GROUP BY s.id
HAVING Enrollments > 1;


*/
-- ----------------------------------------------------------------------------------------------------------------
