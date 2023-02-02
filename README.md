# API Management with GitOps

## Install ArgoCD

```
oc apply -f argocd/operator.yaml
oc apply -f argocd/rbac.yaml
```

Wait 5 minutes and follow up with:

```
oc apply -f argocd/argocd.yaml
oc get routes gitops-server -n openshift-gitops
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

