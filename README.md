# ParseXML

At least 2 departments, 2-3 employees in each department, array of skills, manager’s ids should reference to other employees’ ids (only one of them without such reference)
DOM (JDOM) - parse, query (by emp id), create (1 dep with 1 emp)
Query any employee and recursive query all managers (employee’s manager, manager’s manager and so on)
SAX (StAX) - parse and query (by emp id)
Any approach (preferable XPATH) - create methods: check tag presence, check that tag contains children 
(not simple text node, but nested tags), return list of values for specified tag
