import axios from "axios";
const APIconfig = axios.create({
baseURL: "http://localhost:2020/api/v1",
});
export default APIconfig;
