# API Management with GitOps

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
oc create secret generic threescale-provider-account --from-literal=adminURL=https://user1-admin.apps.cluster-5z7vm.5z7vm.sandbox1343.opentlc.com/  --from-literal=token=6f01c01d8914868ba4b49ffd24fd821965b75da1e208943937987648947392e1
```

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

