import axios from "axios";

const axiosInstance = axios.create({
    baseURL: 'http://localhost:4333/api/admin'
})

export default axiosInstance;
