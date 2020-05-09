## GENERAL INFORMATION
- **language of the project:** English (documentation, issues, code, commits, ...)
- **weekly meetings:** Monday start at 18/19 o´clock
- **communication:** Teams, GitHub, WhatsApp
- **deadlines:** milestones, must be finished 24h before the deadline
- **general determinations:** mutual control (gegenseitige)
- **documentation:** README, javadocs
- **responsibility:** split the responsibility  fair between the teams members

## SOFTWARE
- `GitHub` as Version Control and Project Planning
- `IntelliJ` as IDE
- `LucidChart` for structures
- `Adobe XD` for the design

## DATABASE
 - we use `MariaDB` as DBMS ????
 - JPA??? ORM???
 - Workbench

## CODECONVENTIONS
**Clean Code**

### Database
- method names must be written with the method name from the JPA methods + the entity name
- e.g. findByToolID - **findBy**(method name from JPA) **ToolID**(ID from the entity tool)

### Classes, Methods, Variables
- ... TODO

### Branch naming
- `master`
- `develop` ```/``` DESCRIPTION
- `feature` ```/``` FEATURENAME
- `release` ```/``` RELEASEVERSION
- `hotfix` ```/``` FIXVERSION

e.g.: 
- `develop/database`
- `release/1.2.0`
