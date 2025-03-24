INSERT INTO Users (UserID, UserName, Password, enabled) 
VALUES(1, 'Prem', '$2a$12$a7qaAyfwwW34DzDcttlgw.3JKzl/tYWMH/ClHh6umlscIfeWyhc2W', '1'), (2, 'internal', '$2a$12$iu..7AJK8njCQc1XGUKBAe8gt7oRhIgeybaLFTOLhCCf.rhLfhGcu', '1'), (3, 'external', '$2a$12$iu..7AJK8njCQc1XGUKBAe8gt7oRhIgeybaLFTOLhCCf.rhLfhGcu', '1'), (4, 'panel', '$2a$12$iu..7AJK8njCQc1XGUKBAe8gt7oRhIgeybaLFTOLhCCf.rhLfhGcu', '1'),(5, 'leader', '$2a$12$iu..7AJK8njCQc1XGUKBAe8gt7oRhIgeybaLFTOLhCCf.rhLfhGcu', '1');

INSERT INTO user_authorities 
VALUES('prem', 'ROLE_ADMIN'), ('prem', 'ROLE_USER'),('prem', 'ROLE_INTERNAL'), ('internal', 'ROLE_INTERNAL'), ('internal', 'ROLE_USER'),('external', 'ROLE_EXTERNAL'),('external', 'ROLE_USER'), ('panel', 'ROLE_USER'),('panel', 'ROLE_PANEL'),('leader', 'ROLE_USER'),('leader', 'ROLE_LEADER');

INSERT INTO Modules
VALUES(1,'Web Application and Development', 'HTML and CSS', 'Ian', 'Sheldon Cooper', 'Leonard', 'Raj and Howard'), (2,'Agile Development', 'Scrum Process', 'Wendy', 'Sheldon Cooper', 'Leonard', 'Raj and Howard'), (3,'Java', 'Inheritance', 'Louise', 'Sheldon Cooper', 'Leonard', 'Raj and Howard'),  (4,'Agile Development', 'Agile', 'Maria', 'Sheldon Cooper', 'Leonard', 'Raj and Howard');

INSERT INTO Module_Leader_Form
VALUES(1,'CMT666', 'Web Application and Development', 'Dr Prem Ja', 'HTML and CSS', '1', '2023-12-10', '2023-12-12 12:30:00', '2023-12-30', 'https://mag.wcoomd.org/uploads/2018/05/blank.pdf'), (2,'CMT777', 'Agile Development', 'Wendy', 'Scrum Process', '2', '2023-12-10', '2023-12-12 12:30:00', '2023-12-30', 'https://mag.wcoomd.org/uploads/2018/05/blank.pdf'), (3,'CMT888', 'Java', 'Wendy', 'Inheritance', '3', '2023-12-10', '2023-12-12 12:30:00', '2023-12-30', 'https://mag.wcoomd.org/uploads/2018/05/blank.pdf'), (4,'CMT888', 'Agile Development', 'Wendy', 'Agile', '3', '2023-12-10', '2023-12-12 12:30:00', '2023-12-30', 'https://mag.wcoomd.org/uploads/2018/05/blank.pdf');

INSERT INTO internal_form (Module_Title, Module_Code, Assessment_Period, Type_Of_Assessment, Module_Leader, Internal_Moderator, External_Moderator, Part1, Date_Part1, Part2, Date_Part2, Criteria1, Criteria2, Criteria3, Criteria4, Criteria5, Criteria6, Criteria7, Criteria8, Summary, Part3, Date_Part3
) VALUES ('Web Application and Development', 'CMT612', '2023-2024', 'Coursework', 'Ian', 'Sheldon Cooper', 'Leonard', 1, '2023-10-01', 1, '2023-11-01', 1, 0, 1, 1, 0, 1, 0, 1, 'Updated assessment criteria to align with learning outcomes', 1, '2023-12-01');

INSERT INTO external_form
VALUES(1, 'Web Application', 'CMT555', '2 weeks', 'online', 'Ian', 'Yashashri', 'Arfah', "0", "0", "0", "0", 'Good', '11-12-2023');

INSERT INTO Assessments 
VALUES(1,'Web Application and Development', 'internal'), (2,'Web Agile Development', 'panel'), (3,'Java', 'leader');

INSERT INTO leader_response_form
VALUES(1, 'Web Application', 'CMT555', 'Ian', 'Parth', 'Good', '12-12-2023');
