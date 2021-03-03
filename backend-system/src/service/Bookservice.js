import axios from 'axios';

const api = "http://localhost:8080/data/content";
const api2 = "http://localhost:8080/data";

class Bookservice {

    createBooks(book) {
        return axios.post(api, book, {headers:{"Content-Type" : "application/json"}})
    }

    deleteBooks(id) {
        return axios.delete(api + '/' + id);
    }

    getBookById(id) {
        return axios.get(`${api}/get/${id}`)
    }

    getBooksNamesWithId() {
        return axios.get(`${api2}/namesId`);
    }
}

export default new Bookservice();