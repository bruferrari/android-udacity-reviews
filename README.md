## Udacity Code Reviewer App

Set your token in the gradle.properties file.

`MyUdacityReviewerAPIKey = "my token"`

### To dos

- [ ] Set the token in the app settings so any reviewer can paste their token and download their data
- [ ] Add NETWORK permission to check if there's connectivity before attempting API calls
- [ ] Fetch data when the app is first installed and the token is set
- [x] Pass the start/end date arguments to the callAPI method. The start/end should be the date from the last record, and today (so it only fetches new data). The method is already set to accept the arguments. 

### Reports

- [ ] Reviews by date range
 * Shows number of reviewes by project / % of meets vs doesn't meet
 * Gross revenue
 * Average time spent per project
