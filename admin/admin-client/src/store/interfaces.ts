export class Contract {
  id: string;
  contractNumber: string;
  type: string;
  client: string;
  price: number;
  signDate: string;
  endDate: string;
  updated: string;

  constructor(id?: string, contractNumber?: string, type?: string, client?: string, price?: number, signDate?: string, endDate?: string, updated?: string) {
    this.id = id || '';
    this.contractNumber = contractNumber || '';
    this.type = type || '';
    this.client = client || '';
    this.price = price || 0;
    this.signDate = signDate || '';
    this.endDate = endDate || '';
    this.updated = updated || '';
  }
}
export interface Breadcrumb {
  path: string,
  name: string
}
