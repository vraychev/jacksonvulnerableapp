##Purpose of this repo

The repo demonstrates Jackson serialization vulnerability as described in:
 1. https://cowtowncoder.medium.com/on-jackson-cves-dont-panic-here-is-what-you-need-to-know-54cd0d6e8062
 2. https://medium.com/@swapneildash/understanding-insecure-implementation-of-jackson-deserialization-7b3d409d2038
 3. https://blog.doyensec.com/2019/07/22/jackson-gadgets.html
 
The exploitable vulnerability demonstrated here is: https://snyk.io/vuln/SNYK-JAVA-COMFASTERXMLJACKSONCORE-32043. We demonstrate the exploit by remotely executing a calculator app. 

## What this repo contains
* A vulnerable app, run using Micronaut web framework.
* The app exposes two endpoints - POST to `/user`, and POST to `/org`. Both endpoints are vulnerable, see `AppController.java`


## How to run the exploit

### Prerequisites:
* `java 8`
* `maven`
* `realpath` unix command line utility (just to run the script)

### How to run on MacOS
1. `mvn exec:exec` to run the Micronaut server
2. `cd exploit && ./run_org_exploit.sh` 
or
3. `cd exploit && ./run_user_exploit.sh`

You should see the calculator app popping up.
