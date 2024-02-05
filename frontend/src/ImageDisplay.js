import React, { useState, useEffect } from 'react';

const ImageDisplay = () => {
    const [imageSrc, setImageSrc] = useState('');

    useEffect(() => {
        // Fetch image data from your Spring Boot API
        fetch('http://localhost:8080/api/images/3')
            .then(response => response.blob())
            .then(data => {
                const objectURL = URL.createObjectURL(data);
                setImageSrc(objectURL);
            })
            .catch(error => console.error('Error fetching image:', error));
    }, []);

    return (
        <div style={{ width: '100%', height: '100vh', display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
            {imageSrc && <img src={imageSrc} style={{ maxWidth: '100%', maxHeight: '100%', objectFit: 'contain' }} />}
        </div>
    );
};

export default ImageDisplay;
