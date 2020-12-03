import React from "react";

export default function EmptyState(props) {
    const styles = {
        heading : {
            fontFamily: "courier new"
        }
    };

    return(
        <>
            <h3 style={styles.heading}>My Favorite</h3>
            <div className="d-flex w-100 justify-content-center align-items-center row">
                <h4>Belum ada item yang dipilih</h4>
                <h6>Klik salah satu item di List Movies</h6>
            </div>
        </>
    )
}