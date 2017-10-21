import { Component, OnInit } from '@angular/core';
import { Http, Response } from '@angular/http';
import { ApiService } from "./app.api.service"
import { IBook } from "../model/book"
import 'rxjs/add/operator/map';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ApiService]
})
export class AppComponent implements OnInit {
  title = 'app';
  books: IBook[];

  constructor(private apiService: ApiService) {
  }

  getData(): void { 
    this.apiService.getData().subscribe(result => this.books = result);
  }

  ngOnInit(): void {
    this.getData();
  }
}