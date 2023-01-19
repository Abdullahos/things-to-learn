
### i was having my dropbox like this:
![lovUnderBody](https://user-images.githubusercontent.com/51336081/213437961-de1c43c1-5aa6-4281-9e4d-34f78b5aa712.png)

### but i wanted i like that:
![lovOverBody](https://user-images.githubusercontent.com/51336081/213437974-db0ab1ca-c05f-455c-804a-57bfa7dadc78.png)

here's my code in case 1:
```
  <td>
              <ng-select
                        [items]="originalTasks" bindLabel="number" bindValue="id" [(ngModel)]="subline.taskId" 
                        [disabled] = "!variationRequest.isEditable() || !subline.editing">
              </ng-select>
          </td>
```
here's my code in case 2:
```
  <td>
              <ng-select
                        appendTo="body"
                        [items]="originalTasks" bindLabel="number" bindValue="id" [(ngModel)]="subline.taskId" 
                        [disabled] = "!variationRequest.isEditable() || !subline.editing">
              </ng-select>
          </td>
```

clearification:
https://github.com/ng-select/ng-select/blob/master/src/demo/app/examples/append-to-example/append-to-example.component.html
