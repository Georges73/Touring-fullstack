import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Account } from './account-center/account';

@Injectable({
  providedIn: 'root',
})
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const accounts = [
      { id: 11, name: 'Dr Nice', email: 'nice@mail.com' },
      { id: 12, name: 'Narco' , email: 'narco@mail.com'},
      { id: 13, name: 'Bombasto' , email: 'bombas@mail.com'},
      { id: 14, name: 'Celeritas' , email: 'celer@mail.com'},
      { id: 15, name: 'Magneta', email: 'magn@mail.com' },
      { id: 16, name: 'RubberMan', email: 'rubber@mail.com' },
      { id: 17, name: 'Dynama', email: 'dyna@mail.com' },
      { id: 18, name: 'Dr IQ', email: 'iq@mail.com' },
      { id: 19, name: 'Magma', email: 'magma@mail.com' },
      { id: 20, name: 'Tornado', email: 'torna@mail.com' }
    ];
    return {accounts};
  }

  // Overrides the genId method to ensure that a hero always has an id.
  // If the heroes array is empty,
  // the method below returns the initial number (11).
  // if the heroes array is not empty, the method below returns the highest
  // hero id + 1.
  genId(accounts: Account[]): number {
    return accounts.length > 0 ? Math.max(...accounts.map(account => account.id)) + 1 : 11;
  }
}
