import React, { Component } from "react";
import Hotel from "../../components/Hotel";
import classes from "./styles.module.css";

class HotelList extends Component {
    constructor(props) {
    super(props);
    this.state = {
        hotels: [
        {
        id: 1,
        namaHotel: "Hotel Papa",
        alamat: "Depok",
        nomorTelepon: "08211234",
        },
        {
        id: 2,
        namaHotel: "Hotel Mama",
        alamat: "Jekardah",
        nomorTelepon: "08211234",
        },
        {
        id: 1,
        namaHotel: "Hotel Dede",
        alamat: "Thepok",
        nomorTelepon: "08211234",
        }
    ],
    isLoading: false,
    };
    }
    render() {
    return (
    <div className={classes.hotelList}>
    <h1 className={classes.title}>All Hotels</h1>
    <div>
    {this.state.hotels.map((hotel) => (
    <Hotel
    key={hotel.id}
    id={hotel.id}
    namaHotel={hotel.namaHotel}
    alamat={hotel.alamat}
    nomorTelepon={hotel.nomorTelepon}
    />
    ))}
    </div>
    </div>
    );
    }
    }
    export default HotelList;