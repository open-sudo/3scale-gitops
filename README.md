# API Management with GitOps
## OpenShift
First log in into OpenShift using the CLI. Make sure you are cluster admin.


## CamelK Installation

```
oc project threescale
```
Install Camel K Operator:
```
kamel install
```
## Install ArgoCD

```
oc apply -f argocd/operator.yaml
oc apply -f argocd/rbac.yaml
```

Wait 5 minutes and follow up with:

```
oc apply -f argocd/argocd.yaml
oc get routes openshift-gitops-server -n openshift-gitops
```
## Create Secret
Get an access from 3scale and create a secret:

```
export THREE_SCALE_API_SERVER=`oc whoami --show-server |  cut -c12- | awk '{print "https://user1-admin.apps"$1}' | rev | cut -c6- | rev`
echo $THREE_SCALE_API_SERVER
```
Use the resulting URL to access 3scale and get your account access token
```
export ACCESS_TOKEN=heheheheexample
oc create secret generic threescale-provider-account --from-literal=adminURL=${THREE_SCALE_API_SERVER}  --from-literal=token=${ACCESS_TOKEN}
```

Obtain GitOps URL with:

```
echo `oc whoami --show-server |  cut -c12- | awk '{print "https://openshift-gitops-server-openshift-gitops.apps"$1}' | rev | cut -c6- | rev`
```
Log in into GitOps using the OpenShift Log in Option.

## Camel K APIs

Deploy Camel routes and review:
```
cd camelk
kamel run Fruits.groovy
kamel run Vegetables.groovy
```
Wait till they are fully deployed and get the routes
```
kamel get
```
Get the routes:

```
oc get routes
```
Include these routes in Federated.groovy then deploy it:

```
kamel run Federated.groovy
```

Review the APIs, invoke them, look at the results. Modify the Federate.grooy to include transform.json.



## Open ArgoCD UI
Copy the ArgoCD URL and open it with a browser. Login with OpenShift.

Validate that there is no product in 3scale.

## Deploy APIs with GitOps
Review products/product.yaml and products/backend.yaml

Now apply:

```
oc apply -f argocd/application.yaml
```

Verify how the application is created in GitHub and the API is created in 3scale

