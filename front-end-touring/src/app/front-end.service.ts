import { Injectable } from '@angular/core';
import {Account} from './account-center/account';
// import { getMaxListeners } from 'cluster';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class FrontEndService {

  private accountUrl = 'api/accounts';  // URL to web api

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(
    private http: HttpClient,
    ) { }

    getAccount(id: number): Observable<Account> {
      const url = `${this.accountUrl}/${id}`;
      return this.http.get<Account>(url).pipe(
        tap(_ => this.log(`fetched account id=${id}`)),
        catchError(this.handleError<Account>(`getAccount id=${id}`))
      );
    }

    getAccounts(): Observable<Account[]> {
      return this.http.get<Account[]>(this.accountUrl)
        .pipe(
          tap(_ => this.log('fetched accounts')),
          catchError(this.handleError<Account[]>('getAccounts', []))
        );
    }

    /**
     * Handle Http operation that failed.
     * Let the app continue.
     * @param operation - name of the operation that failed
     * @param result - optional value to return as the observable result
     */
    private handleError<T>(operation = 'operation', result?: T) {
      return (error: any): Observable<T> => {

        // TODO: send the error to remote logging infrastructure
        console.error(error); // log to console instead

        // TODO: better job of transforming error for user consumption
        this.log(`${operation} failed: ${error.message}`);

        // Let the app keep running by returning an empty result.
        return of(result as T);
      };
    }

     /** Log a HeroService message with the MessageService */
     private log(message: string) {
      // this.messageService.add(`HeroService: ${message}`);
    }

    }

