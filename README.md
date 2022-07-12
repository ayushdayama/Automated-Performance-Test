## Performance/Load Test
### Files in this repo have performnance test results generate using Apache JMeter both in *CLI* and *GUI* mode.
### Website taken as sample: DemoBlaze (Blazemter - [Website Link](https://www.demoblaze.com))

### *Automated Load Testing Process*
#### The [Java file](https://github.com/ayushdayama/Automated-Performance-Test/blob/main/performanceTestAutomate.java) can be used to completely automate the JMeter application.
#### Automated script prerequisites:
* Record the test script either using JMeter's inbuilt support or preferbly using Blazemeter.
* Download the .JMX file and place inside "./Reports/JMX/" folder.
* Alter your JMeter path in code and run the Java code.

### *Manual Load Testing Process*
#### ***CLI***: jmeter -n -t PERFORMANCE-TEST-JMeter.jmx -l PERFORMANCE-TEST-JMeter.jtl -e -o ./PT-DETAILED-WEB-REPORT
#### ***GUI***: Reports generated
* [View Results Tree](https://github.com/ayushdayama/PerformanceTest-Ayush/blob/main/View-Results-Tree-PT.csv) :page_facing_up:
* [Aggregate Report](https://github.com/ayushdayama/PerformanceTest-Ayush/blob/main/AGGREGATE-REPORT-PT.csv) :page_facing_up:
* [Summary Report](https://github.com/ayushdayama/PerformanceTest-Ayush/blob/main/SUMMARY-REPORT-PT.csv) :page_facing_up:
* [Response Time Graph](https://github.com/ayushdayama/PerformanceTest-Ayush/blob/main/RESPONSE-TIME-GRAPH-PT.tif) :chart_with_downwards_trend:
#### Complete performance test results in web browser supported format - .html file :computer:

Dev@Ayush :alien:
