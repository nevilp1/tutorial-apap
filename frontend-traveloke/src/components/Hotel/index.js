import React from "react";
import classes from "./styles.module.css";
import Button from "../Button";
import Kamar from "../Kamar";

const Hotel= (props) => {
    const { id, namaHotel, alamat, nomorTelepon, handleEdit, handleDelete, listKamar } = props;
    return (
    <div className={classes.hotel}>
    <h3>{`ID Hotel ${id}`}</h3>
    <p>{`Nama Hotel: ${namaHotel}`}</p>
    <p>{`Alamat: ${alamat}`}</p>
    <p>{`Nomor Telepon: ${nomorTelepon}`}</p>
    <p>{`List Kamar: `}</p>
    
    {listKamar.length !== 0 ? <div>
    {listKamar.map((kamar) => (
        <Kamar 
        namaKamar={kamar.namaKamar} 
        kapasitasKamar={kamar.kapasitasKamar} />))} </div>
        : <p><b>Hotel Tidak Memiliki Kamar</b></p>}
    <Button onClick={handleEdit} variant="success">
    Edit
    </Button>
    <Button onClick={handleDelete} variant="danger">
    Delete
    </Button>
    </div>
    );
    };
    
export default Hotel;