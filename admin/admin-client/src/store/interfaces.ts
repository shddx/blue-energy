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

export class PageParams {
    page: number
    size: number
    sort: string
    direction: string

    constructor(page: number, size: number, sort: string, direction: string) {
        this.page = page;
        this.size = size;
        this.sort = sort;
        this.direction = direction;
    }

    buildQuery(): string {
        let params = [
            ...(this.page ? ['page=' + this.page] : []),
            ...(this.size ? ['size=' + this.size] : []),
            ...(this.sort ? [`sort=${this.sort},${this.direction}`] : []),
        ]
        return params.join("&");
    }
}

export class ContractSearchParams {
    contractNumber: string | undefined;
    client: string | undefined;
    fromSignDate: string | undefined;
    toSignDate: string | undefined;
    priceLow: number | undefined;
    priceHigh: number | undefined;
    type: string | undefined;

    constructor(contractNumber?: string, client?: string, fromSignDate?: string, toSignDate?: string, priceLow?: number, priceHigh?: number, type?: string) {
        this.contractNumber = contractNumber;
        this.client = client;
        this.fromSignDate = fromSignDate;
        this.toSignDate = toSignDate;
        this.priceLow = priceLow;
        this.priceHigh = priceHigh;
        this.type = type;
    }

    buildSearchQuery(): string {
        let params = [
            ...(this.contractNumber ? ['contractNumber=' + this.contractNumber] : []),
            ...(this.client ? ['client=' + this.client] : []),
            ...(this.fromSignDate ? ['fromSignDate=' + this.fromSignDate] : []),
            ...(this.toSignDate ? ['toSignDate=' + this.toSignDate] : []),
            ...(this.priceLow ? ['priceLow=' + this.priceLow] : []),
            ...(this.priceHigh ? ['priceHigh=' + this.priceHigh] : [])
        ];
        return params.join('&');
    }
}

export interface Breadcrumb {
    path: string,
    name: string
}
