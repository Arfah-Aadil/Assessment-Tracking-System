drop table if exists users;
drop table if exists user_authorities;
drop table if exists Modules;
drop table if exists Assessments;
drop table if exists Module_Leader_Form;
drop table if exists external_form;
drop table if exists leader_response_form;

CREATE TABLE IF NOT EXISTS users (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    UserName VARCHAR(255) NOT NULL,
    Password VARCHAR(255) NOT NULL,
    enabled INT NOT NULL
)engine=InnoDB;


CREATE TABLE IF NOT EXISTS user_authorities(
    UserName VARCHAR(255) NOT NULL,
    authority VARCHAR(255) NOT NULL
)engine=InnoDB;


CREATE TABLE IF NOT EXISTS Modules (
    ModuleID INT PRIMARY KEY AUTO_INCREMENT,
    ModuleName VARCHAR(255) NOT NULL,
    AssessmentTitle VARCHAR(255) NOT NULL,
    ModuleLead VARCHAR(255) NOT NULL,
    ExternalModulator VARCHAR(255) NULL,
    InternalModulator VARCHAR(255) NOT NULL,
    Panel VARCHAR(255) NULL
)engine=InnoDB;


CREATE TABLE IF NOT EXISTS Assessments (
    AssessmentID INT PRIMARY KEY AUTO_INCREMENT,
    AssessmentName VARCHAR(255) NOT NULL,
    Status VARCHAR(50) NOT NULL
)engine=InnoDB;


CREATE TABLE IF NOT EXISTS internal_form (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Module_Title VARCHAR(255) NOT NULL,
    Module_Code VARCHAR(255) NOT NULL,
    Assessment_Period VARCHAR(255) NOT NULL,
    Type_Of_Assessment VARCHAR(255) NOT NULL,
    Module_Leader VARCHAR(255) NOT NULL,
    Internal_Moderator VARCHAR(255) NOT NULL,
    External_Moderator VARCHAR(255) NOT NULL,
    Part1 TINYINT(1) NOT NULL DEFAULT 0,
    Date_Part1 VARCHAR(255) NOT NULL,
    Part2 TINYINT(1) NOT NULL DEFAULT 0,
    Date_Part2 VARCHAR(255) NOT NULL,
    Criteria1 TINYINT(1) NOT NULL DEFAULT 0,
    Criteria2 TINYINT(1) NOT NULL DEFAULT 0,
    Criteria3 TINYINT(1) NOT NULL DEFAULT 0,
    Criteria4 TINYINT(1) NOT NULL DEFAULT 0,
    Criteria5 TINYINT(1) NOT NULL DEFAULT 0,
    Criteria6 TINYINT(1) NOT NULL DEFAULT 0,
    Criteria7 TINYINT(1) NOT NULL DEFAULT 0,
    Criteria8 TINYINT(1) NOT NULL DEFAULT 0,
    Summary VARCHAR(1024) NOT NULL,
    Part3 TINYINT(1) NOT NULL DEFAULT 0,
    Date_Part3 VARCHAR(255) NOT NULL
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS panel_form (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Module_Title VARCHAR(255) NOT NULL,
    Module_Code VARCHAR(255) NOT NULL,
    Assessment_Period VARCHAR(255) NOT NULL,
    Assessment_Type VARCHAR(255) NOT NULL,
    Module_Leader VARCHAR(255) NOT NULL,
    Internal_Moderator VARCHAR(255) NOT NULL,
    External_Moderator VARCHAR(255) NOT NULL,
    Part4 TINYINT(1) DEFAULT 0,
    Date_Part4 VARCHAR(255),
    Panel_Comments VARCHAR(1024),
    Assessment_Approved TINYINT(1) DEFAULT 0,
    Assessment_Approved_Minor TINYINT(1) DEFAULT 0,
    Assessment_Reconsider TINYINT(1) DEFAULT 0,
    Assessment_Resend TINYINT(1) DEFAULT 0,
    Module_Leader_Notified TINYINT(1) DEFAULT 0,
    Date_P1 VARCHAR(255),
    Moderator_Setter_Notified TINYINT(1) DEFAULT 0,
    Date_P2 VARCHAR(255)
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS external_form (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Module_Title VARCHAR(255) NOT NULL,
    Module_Code VARCHAR(255) NOT NULL,
    Assessment_Period VARCHAR(255) NOT NULL,
    Type_Of_Assessment VARCHAR(255) NOT NULL,
    Module_Leader VARCHAR(255) NOT NULL,
    Internal_Moderator VARCHAR(255) NOT NULL,
    External_Moderator VARCHAR(255) NOT NULL,
    Assessment_approved TINYINT(1) NOT NULL DEFAULT 0,
    Approved_to_minor_modification TINYINT(1) NOT NULL DEFAULT 0,
    Assessment_to_be_reconsidered TINYINT(1) NOT NULL DEFAULT 0,
    Assessment_to_be_resent TINYINT(1) NOT NULL DEFAULT 0,
    Feedback VARCHAR(1024) NOT NULL,
    Date_Completed VARCHAR(255) NOT NULL
)engine=InnoDB;



CREATE TABLE IF NOT EXISTS Module_Leader_Form (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Module_Code VARCHAR(255) NOT NULL,
    Module_Title VARCHAR(255) NOT NULL,
    Lecturer VARCHAR(255) NOT NULL,
    Assessment_Title VARCHAR(255) NOT NULL,
    Assessment_Number VARCHAR(255) NOT NULL,
    Date_Set VARCHAR(255) NOT NULL,
    Submission_Date_and_Time VARCHAR(255) NOT NULL,
    Feedback_Return_Date VARCHAR(255) NOT NULL,
    PDF_Link VARCHAR(1024) NOT NULL
)engine=InnoDB;

CREATE TABLE IF NOT EXISTS leader_response_form (
    ID INT PRIMARY KEY AUTO_INCREMENT,
    Module_Title VARCHAR(255) NOT NULL,
    Module_Code VARCHAR(255) NOT NULL,
    Module_Leader VARCHAR(255) NOT NULL,
    Moderator VARCHAR(255) NOT NULL,
    Response_to_moderator_comments VARCHAR(1024) NOT NULL,
    Date_Completed VARCHAR(255) NOT NULL
)engine=InnoDB;