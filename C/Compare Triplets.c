#include<stdio.h>
int score(int *, int *);
int main() {
    int arr[3],arr2[3],*p,*q;
 for(int i=0;i<3;i++){
     scanf("%d",&arr[i]);
     
 }
 
  for(int j=0;j<3;j++){
     scanf("%d",&arr2[j]);
     
 }
 
 p=arr;
 q=arr2;

 score(p,q);
 
 
 return 0;

}
int score(int *arr,int *arr2){
    int count=0,count2=0;
    for(int i=0;i<3;i++){
        if(arr[i]>arr2[i]){
            count++;
        }
        else
        count2++;
    }
    
    printf("%d\t%d",count,count2);
    
    
}
