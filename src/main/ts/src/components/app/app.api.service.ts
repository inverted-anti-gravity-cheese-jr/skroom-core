import {Injectable} from "@angular/core";
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import "rxjs/Rx";
import {IBook} from "../../model/book";

@Injectable()
export class ApiService {

    private _postsURL = "/api/hello";

    constructor(private http: Http) {
    }

    getData(): Observable<IBook[]> {
        return this.http
            .get(this._postsURL)
            .map((response: Response) => {
                return <IBook[]>response.json();
            })
            .catch(this.handleError);
    }

    private handleError(error: Response) {
        return Observable.throw(error.statusText);
    }
}