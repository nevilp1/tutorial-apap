import React from "react";
import classes from "./styles.module.css";
const Hotel = (props) => {
const { id, namaHotel, alamat, nomorTelepon} = props;
return (
<div className={classes.hotel}>
 <h3>{`ID Hotel ${id}`}</h3>
 <p>{`Nama Hotel: ${namaHotel}`}</p>
 <p>{`Alamat: ${alamat}`}</p>
 <p>{`Nomor telepon: ${nomorTelepon}`}</p>
 </div>
);
};
export default Hotel;