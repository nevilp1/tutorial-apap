import React from "react";
import classes from "./styles.module.css";

const Kamar= (props) => {
    const { namaKamar, kapasitasKamar } = props;
    return (
        <a className={classes.kamar}><b>{`${namaKamar} (${kapasitasKamar})`}</b></a>
    );
    };
    
export default Kamar;