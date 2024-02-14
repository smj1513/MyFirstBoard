import {useEffect, useRef, useState} from "react";

export default function Card(props) {
    const containerRef = useRef(null);
    const handleMouseMove = (e)=>{
        const container = containerRef.current;
        let moveX = e.offsetX;
        let moveY = e.offsetY;
        let rotateY = -1 / 5 * moveX + 20
        let rotateX = 4/30 * moveY - 20
        const width = container.offsetWidth;
        const height = container.offsetHeight;
        let perspective = ((width+height)/2)*1.5;
        console.log(perspective)
        container.style.transform = `perspective(${perspective}px) rotateX(${rotateX}deg) rotateY(${rotateY}deg)`;
    }
    useEffect(() => {
        const container = containerRef.current;
        container.addEventListener("mousemove",handleMouseMove)
        return() =>{
            container.removeEventListener("mousemove",handleMouseMove)
        }
    }, []);


    return (

        <div ref={containerRef} className="container" style={{
            marginLeft : '30px',
            marginTop : '40px',
            width: props.width,
            height: props.height,
            transition: 'all 0.1s'
        }}>
            <div className="card" style={{
                width: props.width,
                height: props.height,
                backgroundImage: `url(${props.img})`,
                backgroundSize: "cover"
            }}></div>
        </div>
    )

}